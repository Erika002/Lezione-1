package Utility;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassScanner {

    public static Set<Class<?>> getClassesWithAnnotation(Class<? extends Annotation> annotationClass, String packageName) {
        Set<Class<?>> classesWithAnnotation = new HashSet<>();

        try {
            File[] files = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(packageName.replace(".", "/"))).toURI()).listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().replace(".class", "");
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(annotationClass)) {
                        classesWithAnnotation.add(clazz);
                    }
                }
            }
        } catch (URISyntaxException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return classesWithAnnotation;
    }
}


