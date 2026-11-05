/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Portafolio_SebastianAngulo.repository;

/**
 *
 * @author home
 */

import Portafolio_SebastianAngulo.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    public List<Producto> findByActivoTrue();
    
    public List<Producto> findByPrecioBetweenOrderByPrecioAsc(double precioInf, double precioSup);

    public List<Producto> findByCategoriaIdCategoria(Integer idCategoria);

    @Query(nativeQuery= true, value="SELECT * FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Producto> consultaSQL(@Param("precioInf")double precioInf, @Param("precioSup") double precioSup);
}
