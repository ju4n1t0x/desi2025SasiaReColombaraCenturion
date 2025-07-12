package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;  

@Entity

public class Familia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "nro_familia")
    private int nroFamilia;

    @NotBlank(message = "El nombre de la familia no puede estar vacío")
    @Column(unique = true)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaRegistro = LocalDate.now();

    @Column(nullable = false)
    private boolean activo = true;
	
	@OneToMany(mappedBy = "familia")
	private List<EntregaAsistencia> entregaAsistencia;
	
	// --- NUEVA RELACIÓN ONE-TO-MANY CON ASISTIDO ---
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asistido> asistidos = new ArrayList<>(); // Inicializar para evitar NullPointerException
    
    public long getCantidadIntegrantesActivos() {
        if (asistidos == null) {
            return 0;
        }
        return asistidos.stream()
                .filter(Asistido::isActivo)
                .count();
    }
    
    public Familia() {
    }

    public Familia(int nroFamilia, String nombre, LocalDate fechaRegistro, boolean activo, List<Asistido> asistidos) {
        this.nroFamilia = nroFamilia;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
        this.asistidos = asistidos;
    }
	
    public int getNroFamilia() {
        return nroFamilia;
    }

    public void setNroFamilia(int nroFamilia) {
        this.nroFamilia = nroFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Asistido> getAsistidos() {
        return asistidos;
    }

    public void setAsistidos(List<Asistido> asistidos) {
        this.asistidos = asistidos;
    }
    

	
	
}
