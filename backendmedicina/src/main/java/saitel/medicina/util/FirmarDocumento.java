package saitel.medicina.util;

public class FirmarDocumento {
    private String documento; // PDF en base64
    private String clave;
    private String etiqueta;
    private Long idEmpleado;
    private int qrDimension;
    private String nombreDocumento;
    private boolean ubicarFirma;
    private int pagina;
    private float cordX;
    private float cordY;
    private int orden;

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getEtiqueta() { return etiqueta; }
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }

    public Long getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Long idEmpleado) { this.idEmpleado = idEmpleado; }

    public int getQrDimension() { return qrDimension; }
    public void setQrDimension(int qrDimension) { this.qrDimension = qrDimension; }

    public String getNombreDocumento() { return nombreDocumento; }
    public void setNombreDocumento(String nombreDocumento) { this.nombreDocumento = nombreDocumento; }

    public boolean isUbicarFirma() { return ubicarFirma; }
    public void setUbicarFirma(boolean ubicarFirma) { this.ubicarFirma = ubicarFirma; }

    public int getPagina() { return pagina; }
    public void setPagina(int pagina) { this.pagina = pagina; }

    public float getCordX() { return cordX; }
    public void setCordX(float cordX) { this.cordX = cordX; }

    public float getCordY() { return cordY; }
    public void setCordY(float cordY) { this.cordY = cordY; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }
}
