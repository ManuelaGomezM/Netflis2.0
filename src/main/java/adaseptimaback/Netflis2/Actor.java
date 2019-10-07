package adaseptimaback.Netflis2;

public class Actor {

        private String name;

        public Boolean actuoEn(Contenido contenido){
            return contenido.actuo(this);
        }
        public Actor (String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



