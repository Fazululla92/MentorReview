package Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties config;

    public Config() {
        reset();
    }

    public void reset() {
        try {
            Properties base = new Properties();

            Properties temp = new Properties();
            temp.load(new FileInputStream("config.properties"));

            String defaults = temp.getProperty("default.filenames");

            if (defaults != null) {
                String[] files = split(defaults);

                Properties current = base;

                for (int i = files.length - 1; i >= 0; i--) {
                    Properties p = new Properties(current);
                    p.load(new FileInputStream(files[i] + ".properties"));
                    current = p;
                }

                Properties finalProps = new Properties(current);
                finalProps.load(new FileInputStream("config.properties"));
                config = finalProps;
            } else {
                Properties p = new Properties();
                p.load(new FileInputStream("config.properties"));
                config = p;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return config.getProperty(key);
    }

    public void set(String key, String value) {
        config.setProperty(key, value);
    }

    public void save() {
        try {
            Properties base = new Properties();

            FileInputStream in = new FileInputStream("config.properties");
            base.load(in);
            in.close();

            for (Object k : config.keySet()) {
                String key = (String) k;
                base.setProperty(key, config.getProperty(key));
            }

            FileOutputStream out = new FileOutputStream("config.properties");
            base.store(out, null);
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(String key) {
        config.remove(key);
    }

    private String[] split(String s) {
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') count++;
        }

        String[] res = new String[count];
        int start = 0, idx = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ',') {
                res[idx++] = s.substring(start, i).trim();
                start = i + 1;
            }
        }

        return res;
    }
}
