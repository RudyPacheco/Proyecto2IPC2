import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-revistas-page',
  templateUrl: './revistas-page.component.html',
  styleUrls: ['./revistas-page.component.css']
})
export class RevistasPageComponent implements OnInit {

  revistasEditor:revista[]=[];
  
  revistaS!: revista;

  constructor(private loginService:loginServices,private revsitaService:revistaService,private router:Router,private edicionService:edicionService) { 
    this.revsitaService.editor=this.loginService.getUsuario().usuario;
    this.revsitaService.getlistarTodasRevistas().subscribe((revista:revista[])=>{
      this.revistasEditor=revista;
    })
  }


ediciones(revistaR:revista){
  this.edicionService.revistaSelect=revistaR;
this.router.navigate(['Edicones'])
}

ngOnInit(): void {
}

  imprimir(){
    console.log(this.revistasEditor.values);
  }

  selectElement(revista:revista){
    this.revsitaService.emisorSeleccion.emit(
      revista
    );
  }


  permisosRevista(revista:revista){
    this.revsitaService.revistaSelec=revista;
    
    this.router.navigate(['FormPermisos']);
  }
}

  

