package com.xiaohe66.demo.se.jvm.classloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 自定义类加载器，打破双亲委派机制，实现不同版本类的隔离（如tomcat的多项目共存）
 *
 * @author xiaohe
 * @time 2020.06.18 16:27
 */
public class MyClassloader extends ClassLoader {

    private final String classPath;

    MyClassloader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 打破双亲委派机制
     *
     * <p>直接复制父类的加载类方法，再作简单修改
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();

                // 系统关键类必须要由引导类加载器加载，
                // 因此系统关键类，必须由父类加载器加载
                // 若所有的类都由自己的加载器加载，则会缺少JDK中的Object类
                if (!name.equals("com.xiaohe66.demo.se.jvm.classloader.User")) {
                    // 注释下面这行代码，可看到缺少Object类的情况
                    c = this.getParent().loadClass(name);
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String absPath = name.replaceAll("\\.", "/") + ".class";

        Path path = FileSystems.getDefault().getPath(classPath + File.separator + absPath);

        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }

        return defineClass(name, bytes, 0, bytes.length);
    }
}
