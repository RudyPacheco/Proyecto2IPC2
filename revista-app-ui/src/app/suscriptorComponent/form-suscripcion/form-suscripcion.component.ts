import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';
import { revistaService } from 'src/app/services/revista/revista.service';
import { suscripcionService } from 'src/app/services/suscripcion/suscripcion.service';
import { suscripcion } from 'src/models/auth/suscripcion/suscripcion.model';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-form-suscripcion',
  templateUrl: './form-suscripcion.component.html',
  styleUrls: ['./form-suscripcion.component.css']
})
export class FormSuscripcionComponent implements OnInit {


  suscripcionForm:FormGroup;
  array:string[]=[]
  revistaR:revista;
  precioSub:number=0;
  mostrarPrecio:boolean=false;
  suscripcionN!:suscripcion;

  constructor(private revsistaService:revistaService,private router:Router,private builder:FormBuilder,private suscripcionService:suscripcionService,private loginSerivce:loginServices) {
      this.revistaR = new revista(0,"",0,"","",this.array,"","",true,true);
      this.suscripcionForm=this.builder.group({
        fechaSuscripcion:['',Validators.required],
        tipoSuscripcion:[null,Validators.required]
      });
   }




  ngOnInit(): void {
    this.revistaR = this.revsistaService.revistaSelec;
  }

  click(){
    var tipoPago =this.suscripcionForm.get("tipoSuscripcion")?.value;
    if (tipoPago==1) {
      this.precioSub=this.revistaR.precioRevista;
      this.mostrarPrecio=true;
      console.log(this.precioSub);
    }else if (tipoPago==2) {
      this.precioSub= (this.revistaR.precioRevista*12);
      console.log(this.precioSub);
      this.mostrarPrecio=true;
    }
  }


  suscribirse(){
    console.log(this.suscripcionForm.value);
  
    this.suscripcionN=this.suscripcionForm.value;
    this.suscripcionN.revista=this.revistaR;
    this.suscripcionN.nombreUsuario=this.loginSerivce.usuario.usuario;
    this.suscripcionService.generarSuscripcion(this.suscripcionN).subscribe((create:suscripcion)=>{
      this.router.navigate(['Suscripciones']);
    })

  }




}
