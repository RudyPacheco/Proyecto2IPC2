import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { suscripcionService } from 'src/app/services/suscripcion/suscripcion.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-mi-suscripcion',
  templateUrl: './mi-suscripcion.component.html',
  styleUrls: ['./mi-suscripcion.component.css']
})
export class MiSuscripcionComponent implements OnInit {

  revistasP:revista[]=[];


  constructor(private loginService:loginServices,private suscripcionService:suscripcionService,private edicionService:edicionService,private router:Router,private revistaService:revistaService) { 
    this.suscripcionService.usuario=this.loginService.getUsuario().usuario;
    this.suscripcionService.getlistaRevistasSuscritas().subscribe((revista:revista[])=>{
      this.revistasP=revista;
    })
  }


ediciones(revistaR:revista){
  this.edicionService.revistaSelect=revistaR;
  console.log(revistaR);
this.router.navigate(['Ediciones/Suscripciones']);
}

detalles(revistaR:revista){
  this.revistaService.revistaSelec=revistaR;
  console.log(revistaR);
this.router.navigate(['DetallesRevista']);  
}



  ngOnInit(): void {
  }

}
