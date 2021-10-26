import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { editorService } from 'src/app/services/revista/editorInfo.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-previ-revista',
  templateUrl: './previ-revista.component.html',
  styleUrls: ['./previ-revista.component.css']
})
export class PreviRevistaComponent implements OnInit {

  array:string[]=[]
  revistaR:revista;
  bloqueo_sub:boolean=false;

  constructor(private revsistaService:revistaService,private router:Router, private editorService:editorService) {
      this.revistaR = new revista(0,"",0,"","",this.array,"","",true,true);
   }


   navegar(){
     this.revsistaService.revistaSelec=this.revistaR;
     this.router.navigate(['FormPago'])
     
   }

   verPerfil(){
     this.editorService.usuario=this.revistaR.editor;
     this.router.navigate(['PerfilEditor']);
   }



  ngOnInit(): void {
    this.revsistaService.emisorSeleccion.subscribe((revista:revista)=>{
      this.revistaR=revista;
      this.bloqueo_sub=revista.bloqueoSub;
    })
  }

}
