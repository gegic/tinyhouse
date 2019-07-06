/***********************************************************************
 * Module:  TipKorisnika.java
 * Author:  Gegic
 * Purpose: Defines the Class TipKorisnika
 ***********************************************************************/
package model;

import java.io.Serializable;

public enum TipKorisnika implements Serializable {
    obican,
    moderator,
    admin;
}