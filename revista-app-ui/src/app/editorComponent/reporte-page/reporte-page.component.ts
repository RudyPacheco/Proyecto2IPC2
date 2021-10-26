import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-reporte-page',
  templateUrl: './reporte-page.component.html',
  styleUrls: ['./reporte-page.component.css']
})
export class ReportePageComponent implements OnInit {

  revistasEditor:revista[]=[];

  constructor(private loginService:loginServices,private revsitaService:revistaService,private router:Router,private edicionService:edicionService) { 
    this.revsitaService.editor=this.loginService.getUsuario().usuario;
    this.revsitaService.getlistaRevistasEditor().subscribe((revista:revista[])=>{
      this.revistasEditor=revista;
    })
  }

  ngOnInit(): void {
  }

}
