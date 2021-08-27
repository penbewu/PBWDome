package com.example.myapplication.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * sky
 * 2021/3/19 10:54
 */
public class LogInBean implements Serializable {

    private List<LogInBeanDa> list ;

    public List<LogInBeanDa> getList() {
        return list;
    }

    public void setList(List<LogInBeanDa> list) {
        this.list = list;
    }

    public static class LogInBeanDa implements Serializable{

        private int type;
        private String name;
        private int imagId;
        private String imagUrl;
        private boolean isSele;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getImagId() {
            return imagId;
        }

        public void setImagId(int imagId) {
            this.imagId = imagId;
        }

        public String getImagUrl() {
            return imagUrl;
        }

        public void setImagUrl(String imagUrl) {
            this.imagUrl = imagUrl;
        }

        public boolean isSele() {
            return isSele;
        }

        public void setSele(boolean sele) {
            isSele = sele;
        }

        @Override
        public String toString() {
            return "LogInBeanDa{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    ", imagId=" + imagId +
                    ", imagUrl='" + imagUrl + '\'' +
                    ", isSele=" + isSele +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LogInBean{" +
                "list=" + list +
                '}';
    }
}
