import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar-producto',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './agregar-producto.component.html'
})
export class AgregarProductoComponent {
  producto: Producto = new Producto();
  
  constructor(private productoServicio: ProductoService, private enrutador: Router){}


  onSubmit(){
    this.guardarProducto();
  }

  guardarProducto(){
    this.productoServicio.agregarProducto(this.producto).subscribe(
      {
        next:(datos)=>{
          console.log("SE GUARDÓ");
          console.log(datos);
          this.irListaProductos();
        },
        error:(error: any) => { console.log(error)}
      }
    )
  }

  irListaProductos(){
    this.enrutador.navigate(['/productos']);
  }
}
