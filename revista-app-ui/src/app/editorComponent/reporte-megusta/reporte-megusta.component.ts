import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { loginServices } from 'src/app/services/login/login.services';
import { reportesEditorService } from 'src/app/services/reportes/reportesEditor.service';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { leerRevistaService } from 'src/app/services/revista/leerRevista.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { edicionModel } from 'src/models/revista/edicion.model';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-reporte-megusta',
  templateUrl: './reporte-megusta.component.html',
  styleUrls: ['./reporte-megusta.component.css']
})
export class ReporteMegustaComponent implements OnInit {

  revistasEditor:revista[]=[];
  reporteForm!:FormGroup;
  fechaI='';
  fechaF = '';
  revsiaS!:revista;
  codigo:number=0;
  reporteP!:string;
  edicion!:edicionModel;
  mostrar =true;
  reportComentario!:string;

  constructor(private loginService:loginServices,private revsitaService:revistaService,private router:Router,private edicionService:edicionService,private builder:FormBuilder,private reporteService:reportesEditorService,private leerRevista:leerRevistaService) { 
    this.revsitaService.editor=this.loginService.getUsuario().usuario;
    this.revsitaService.getlistaRevistasEditor().subscribe((revista:revista[])=>{
      this.revistasEditor=revista;
    });
    this.reporteForm=this.builder.group({
      revista:['']
    })
  
  }


  public modificarFechaI(event: Event) {
    this.fechaI = (<HTMLInputElement>event.target).value;
  }

  public modificarFechaF(event: Event) {
    this.fechaF = (<HTMLInputElement>event.target).value;
  }

  mostrarReporte(){
    this.revsiaS=this.reporteForm.value.revista;
   

    console.log(this.fechaF + this.fechaI + this.reporteForm.get("revista")?.value);
   this.reportComentario=this.reporteService.veRreporteMeGusta(this.reporteForm.get("revista")?.value,this.fechaI,this.fechaF);
    this.mostrar=true;
  }

  descargarReporte(){
    console.log(this.fechaF + this.fechaI + this.reporteForm.get("revista")?.value);
    const revi =this.reporteService.descargaReporteMeGusta(this.reporteForm.get("revista")?.value,this.fechaI,this.fechaF);
     window.location.href=""+revi
    //this.mostrar=true;
  }

  ngOnInit(): void {
  }

}
