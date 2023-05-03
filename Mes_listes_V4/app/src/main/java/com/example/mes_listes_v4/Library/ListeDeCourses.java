package com.example.mes_listes_v4.Library;

import com.example.mes_listes_v4.Class.ItemCourse;

import java.util.ArrayList;
import java.util.Date;

    public class ListeDeCourses {
        private ArrayList<ItemCourse> items;
        private String nomListe;
        private Date dateCreation;

        public ListeDeCourses(String nomListe) {
            this.nomListe = nomListe;
            this.dateCreation = new Date();
            this.items = new ArrayList<>();
        }

        public void ajouterItem(String nom, int quantite, String magasin) {
            ItemCourse item = new ItemCourse(nom, quantite, magasin);
            this.items.add(item);
        }

        public void marquerItemAchete(int index) {
            if (index >= 0 && index < this.items.size()) {
                ItemCourse item = this.items.get(index);
                item.setAchete(true);
            }
        }

        public void ajouterRappel(int index, Date dateRappel) {
            if (index >= 0 && index < this.items.size()) {
                ItemCourse item = this.items.get(index);
                item.setDateRappel(dateRappel);
            }
        }

        public ArrayList<ItemCourse> getItems() {
            return items;
        }

        public String getNomListe() {
            return nomListe;
        }

        public Date getDateCreation() {
            return dateCreation;
        }


    }
