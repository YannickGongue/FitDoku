package com.example.thejoega.fitdoku;

/**
 * Created by yan on 22/07/2019.
 */

public class MemoData {
        private String Name1;
        private int Anzahl;
        private long id;

        public MemoData(String product, int quantity, long id) {
            this.id = id;
            this.Name1 = product;
            this.Anzahl = quantity;
        }

        public String getProduct() {
            return Name1;
        }

        public void setProduct(String product) {
            this.Name1 = product;
        }


        public int getQuantity() {
            return Anzahl;
        }

        public void setQuantity(int quantity) {
            this.Anzahl = quantity;
        }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


        @Override
        public String toString() {
            String output = Anzahl + " - " + Name1;

            return output;
        }
    }
