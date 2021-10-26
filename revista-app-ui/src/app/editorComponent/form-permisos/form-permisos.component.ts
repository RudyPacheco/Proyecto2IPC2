import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { interaccionService } from 'src/app/services/interaccion/interaccion.service';
import { editorService } from 'src/app/services/revista/editorInfo.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { permisosModel } from 'src/models/interacciones/permisos.model';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-form-permisos',
  templateUrl: './form-permisos.component.html',
  styleUrls: ['./form-permisos.component.css']
})
export class FormPermisosComponent implements OnInit {

  array:string[]=[]
  revistaR:revista;
  interaccionR:boolean=false;
  bloqueo_sub:boolean=false;
  permisoForm!:FormGroup;
  interaccion:string;
  permisoSub:string;
  permisoM!:permisosModel;

  constructor(private revsistaService:revistaService,private router:Router, private editorService:editorService,private builder:FormBuilder,private interaccionService:interaccionService) {
      //this.revistaR = new revista(0,"",0,"","",this.array,"","",true,true);

      this.revistaR=this.revsistaService.revistaSelec;
     
      if (this.revistaR.interaccion=true) {
        this.interaccion="Activado";
      }else{
        this.interaccion="Desactivado";
      }
      if (this.revistaR.bloqueoSub=true) {
        this.permisoSub="Desactivado";
      }else{
        this.permisoSub="Activado";
      }
      
      this.permisoForm=this.builder.group({
        permisoInteraccion:[this.interaccion,Validators.required],
        permisoSub:[this.permisoSub, Validators.required]
      })
   }

   guardarCambios(){
     //console.log(this.permisoForm.value);

     console.log(this.revsistaService.revistaSelec.codigo);
    
     if (this.permisoForm.get("permisoInteraccion")?.value==1) {
       this.interaccionR=true;
     }else{
      this.interaccionR=false;
     }
     if (this.permisoForm.get("permisoSub")?.value==1) {
       this.bloqueo_sub=true;
     }else{
      this.bloqueo_sub=false;
     }
   
     this.permisoM= new permisosModel(this.revsistaService.revistaSelec.codigo,this.interaccionR,this.bloqueo_sub);

      console.log(this.permisoM);
     this.interaccionService.actualizarPermisos(this.permisoM).subscribe((data)=>{
       console.log("permisos actualizados")
     })

   }


  ngOnInit(): void {
    
  }

}
