package com.example.printing3d.managing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String color;
        private String material;

        public Orders(){ }
        public Orders(String imgName, String color,String material) {
            this.name=imgName;
            this.color=color;
            this.material=material;
        }

        @Override
        public String toString() {
            return "Orders{" +
                    "imageName=" + name + '\''+
                    ", color=" + color + '\'' +
                    ", material=" + material + '\'' +
                    '}';
        }
        public void setName(String imageName){
            this.name=imageName;
        }
        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

