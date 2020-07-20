package ru.frechman.wget;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Object[] validatedArgs = processArgs(args);
        if (validatedArgs == null) {
            return;
        }

        final String url = (String) validatedArgs[0];
        final long limitKb = (long) validatedArgs[1];

        Main.download(url, limitKb);
    }

    private static Object[] processArgs(final String[] args) {
        if (args.length < 2) {
            System.out.println("Error! Need enter arguments");
            return null;
        }
        String url = args[0];
        if (url == null || url.trim().length() == 0) {
            System.out.println("Error. URL ....");
            return null;
        }

        long limit;
        try {
            limit = Long.parseLong(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("Error. Number ...");
            return null;
        }
        return new Object[]{url, limit};
    }

    private static void download(String url, long limitKb) {
//        String file = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";
        long SECOND = 1000;
        String file = url;
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fos = new FileOutputStream("tmp.xml")
        ) {
            limitKb *= 1024;
            long downloadedBytesPerSec  = 0;

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            long start = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fos.write(dataBuffer, 0, bytesRead);

                downloadedBytesPerSec += bytesRead;
                //если за меньше чем 1секунду загрузилось больше килобайт чем лимит
                if (downloadedBytesPerSec >= limitKb) {
                    long diff = System.currentTimeMillis() - start;
                    if (diff < SECOND) {
                        Thread.sleep(SECOND - diff);
                        downloadedBytesPerSec = 0;
                        start = System.currentTimeMillis();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error. Destination source incorrect.");
        } catch (MalformedURLException e) {
            System.out.println("Error. Incorrect URL.");
        } catch (IOException e) {
            System.out.println("Error. Connection error.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
