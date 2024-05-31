// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.sfr.clinic_app.api.Models;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import java.time.OffsetDateTime;

public class Product {

    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("fecha")
    private OffsetDateTime fecha;
    @SerializedName("monto")
    private String monto;
    @SerializedName("producto_id")
    private String productoid;
    @SerializedName("categoria_id")
    private String categoriaid;
    @SerializedName("nombre")
    private String nombre;

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String value) { this.descripcion = value; }

    public OffsetDateTime getFecha() { return fecha; }
    public void setFecha(OffsetDateTime value) { this.fecha = value; }

    public String getMonto() { return monto; }
    public void setMonto(String value) { this.monto = value; }

    public String getProductoid() { return productoid; }
    public void setProductoid(String value) { this.productoid = value; }

    public String getCategoriaid() { return categoriaid; }
    public void setCategoriaid(String value) { this.categoriaid = value; }

    public String getNombre() { return nombre; }
    public void setNombre(String value) { this.nombre = value; }
}
