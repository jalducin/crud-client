package com.jvav.crudclient.model;

public record Cliente(String id, String nombre, String email, int edad, TipoCliente tipoCliente) {
    public enum TipoCliente {
        REGULAR, VIP
    }
}