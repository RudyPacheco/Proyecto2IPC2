import { Component, OnInit } from '@angular/core';
import { loginServices } from 'src/app/services/login/login.services';
import { suscripcionService } from 'src/app/services/suscripcion/suscripcion.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-mi-suscripcion',
  templateUrl: './mi-suscripcion.component.html',
  styleUrls: ['./mi-suscripcion.component.css']
})
export class MiSuscripcionComponent implements OnInit {

  revistasP:revista[]=[];


  constructor(private loginService:loginServices,private suscripcionService:suscripcionService) { 
    this.suscripcionService.usuario=this.loginService.getUsuario().usuario;
    this.suscripcionService.getlistaRevistasSuscritas().subscribe((revista:revista[])=>{
      this.revistasP=revista;
    })
  }

  ngOnInit(): void {
  }

}
