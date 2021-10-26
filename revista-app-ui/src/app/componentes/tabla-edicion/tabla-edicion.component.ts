import { Component, Input, OnInit } from '@angular/core';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { leerRevistaService } from 'src/app/services/revista/leerRevista.service';
import { edicionModel } from 'src/models/revista/edicion.model';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-tabla-edicion',
  templateUrl: './tabla-edicion.component.html',
  styleUrls: ['./tabla-edicion.component.css']
})
export class TablaEdicionComponent implements OnInit {

  edicionesRevista:edicionModel[]=[];
  
  revistaSelect:revista;
  mostrar:boolean=false;
  revistaPdf!:string;


  constructor(private edicionService:edicionService,private leerService:leerRevistaService) {
    this.revistaSelect=this.edicionService.revistaSelect;
    this.edicionService.getlistaEdiciones().subscribe((ediciones:edicionModel[])=>{
      this.edicionesRevista=ediciones;
    })


   }


   mostrarR(edicion:edicionModel){
    this.revistaPdf=this.leerService.downloadImage(edicion);
    this.mostrar=true;

    

   }


  ngOnInit(): void {
  }

}
