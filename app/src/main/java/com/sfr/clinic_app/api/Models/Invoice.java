// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.sfr.clinic_app.api.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import java.time.LocalDate;

public class Invoice {
    @SerializedName("factura_id")
    @Expose
    private int facturaid;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("monto")
    @Expose
    private int monto;
    @SerializedName("producto_nombre")
    @Expose
    private String productoNombre;
    @SerializedName("fecha_emision")
    @Expose
    private String fechaEmision;
    @SerializedName("producto_descripcion")
    @Expose
    private String productoDescripcion;
    @SerializedName("paciente_id")
    @Expose
    private String pacienteid;

    public int getFacturaid() { return facturaid; }
    public void setFacturaid(int value) { this.facturaid = value; }

    public String getEstado() { return estado; }
    public void setEstado(String value) { this.estado = value; }

    public int getMonto() { return monto; }
    public void setMonto(int value) { this.monto = value; }

    public String getProductoNombre() { return productoNombre; }
    public void setProductoNombre(String value) { this.productoNombre = value; }

    public String getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(String value) { this.fechaEmision = value; }

    public String getProductoDescripcion() { return productoDescripcion; }
    public void setProductoDescripcion(String value) { this.productoDescripcion = value; }

    public String getPacienteid() { return pacienteid; }
    public void setPacienteid(String value) { this.pacienteid = value; }
}
