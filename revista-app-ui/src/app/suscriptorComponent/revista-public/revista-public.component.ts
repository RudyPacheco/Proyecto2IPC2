import { Component, OnInit } from '@angular/core';
import { loginServices } from 'src/app/services/login/login.services';
import { revistaService } from 'src/app/services/revista/revista.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-revista-public',
  templateUrl: './revista-public.component.html',
  styleUrls: ['./revista-public.component.css']
})
export class RevistaPublicComponent implements OnInit {

  revistasP:revista[]=[];


  constructor(private loginService:loginServices,private revistaService:revistaService) { 
    this.revistaService.usuario=this.loginService.getUsuario().usuario;
    this.revistaService.getlistaRevistasGenerales().subscribe((revista:revista[])=>{
      this.revistasP=revista;
    })
  }


  selectElement(revista:revista){
    this.revistaService.emisorSeleccion.emit(
      revista
    );
  }

  ngOnInit(): void {
  }

}
