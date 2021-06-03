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
        private String sizeradio;
        private String price;

        public Orders(){ }
        public Orders(String imgName, String color,String material, String sizeradio, String price) {
            this.name=imgName;
            this.color=color;
            this.material=material;
            this.sizeradio=sizeradio;
            this.price=price;
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

    public String getSizeradio() {
        return sizeradio;
    }

    public void setSizeradio(String sizeradio) {
        this.sizeradio = sizeradio;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

