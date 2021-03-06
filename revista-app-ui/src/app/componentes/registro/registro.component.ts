import { Reference } from '@angular/compiler/src/render3/r3_ast';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { registroServices } from 'src/app/services/registro/registro.service';
import { UsuarioNuevo } from 'src/models/register/newUsuario';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  registroForm!:FormGroup;
  usuarioNuevo !: UsuarioNuevo;

  constructor(private router:Router, private builder:FormBuilder,private registroService:registroServices) {
    this.registroForm = this.builder.group({
      nombre:['', Validators.required],
      apellido:['', Validators.required],
      usuario:['', Validators.required],
      contrasenia:['', Validators.required],
      tipoCuenta:[null,Validators.required ],
    })

   }

   registrar(values:any){
   if (this.registroForm.valid) {
     console.log(values);
  
     this.registroService.generarRegistro(this.registroForm.value).subscribe((create: UsuarioNuevo)=>{

     
      this.registroForm.reset({
        nombre:'',
        apellido:'',
        usuario:'',
        contrasenia:'',
        tipoCuenta:null,
      });
      console.log("created");
      console.log(create);
    
      this.registroService.setUsuario(create);
      this.registroService.usuarioNuevo=create;
 
      //console.log(this.registroService.getUsuario().tipoCuenta);
      //console.log(create.Nombre);
      console.log(this.registroService.getUsuario());
   
      this.router.navigate(['informacion']);
    
     },

     
     (error: any)=>{
      console.log("error")
     });

   }
   }

  ngOnInit(): void {
  }

}
