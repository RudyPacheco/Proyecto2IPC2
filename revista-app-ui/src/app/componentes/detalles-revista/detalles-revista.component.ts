import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { interaccionService } from 'src/app/services/interaccion/interaccion.service';
import { loginServices } from 'src/app/services/login/login.services';
import { editorService } from 'src/app/services/revista/editorInfo.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { comentario } from 'src/models/interacciones/comentario';
import { meGusta } from 'src/models/interacciones/megusta.model';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-detalles-revista',
  templateUrl: './detalles-revista.component.html',
  styleUrls: ['./detalles-revista.component.css']
})
export class DetallesRevistaComponent implements OnInit {

  array:string[]=[]
  revistaR:revista;
  comentarioFomr!:FormGroup;
  interaccion:boolean=false;
  comentarioR!:comentario;
  meGusta!:meGusta;
  megustas:meGusta[]=[];
  comentariosR:comentario[]=[];
  yaGusta:boolean=false;


  constructor(private revsistaService:revistaService,private router:Router, private editorService:editorService,private builder:FormBuilder,private loginService:loginServices,private intereaccionService:interaccionService) {
     //this.revistaR = new revista(0,"",0,"","",this.array,"","",true,);
     
     this.revistaR=this.revsistaService.revistaSelec;
    this.comentarioFomr=this.builder.group({
      comentario:['',Validators.required]
    })
    this.intereaccionService.codigoRevista=this.revsistaService.revistaSelec.codigo;
    this.intereaccionService.usuario=this.loginService.usuario.usuario;
    this.intereaccionService.listarMegustaUsuario().subscribe((likes:meGusta[])=>{
      this.megustas=likes;
      this.megustas.forEach(reaccion=>{
        if (reaccion.codigoRevista === this.revsistaService.revistaSelec.codigo) {
          this.yaGusta=true;
        }
      });
    }); 

    this.intereaccionService.listarComentariosRevista().subscribe((coment:comentario[])=>{
      this.comentariosR=coment;
    });
    this.interaccion=this.revsistaService.revistaSelec.interaccion;

   }

   comentar(){
  //   let xd = this.comentarioFomr.get("comentario")?.value;
  //  this.comentarioR.comentario=xd;
   
  //  this.comentarioR.comentario=this.comentarioFomr.value;
  //   this.comentarioR.codigoRevista=this.revsistaService.revistaSelec.codigo;
  //   this.comentarioR.fechaComentario=this.loginService.fechaActual;
  //   this.comentarioR.nombreUsuario=this.loginService.usuario.usuario;
  this.comentarioR= new comentario(this.loginService.usuario.usuario,this.revsistaService.revistaSelec.codigo,this.comentarioFomr.get("comentario")?.value,this.loginService.fechaActual);
    this.intereaccionService.crearComentario(this.comentarioR).subscribe((coment:comentario)=>{
      console.log("comentario agregado")
      this.comentarioFomr.reset({
        comentario:''
      });
    })
   }

   darMegusta(){
    this.meGusta=new meGusta(this.loginService.usuario.usuario,this.revsistaService.revistaSelec.codigo,this.loginService.fechaActual);
    this.intereaccionService.darMegusta(this.meGusta).subscribe((data)=>{
      console.log("se dio me gusta");
      this.router.navigate(['Suscripciones']);
    })
   }


   
   verPerfil(){
     this.editorService.usuario=this.revistaR.editor;
     this.router.navigate(['PerfilEditor']);
   }



  ngOnInit(): void {
   
    // this.revsistaService.emisorSeleccion.subscribe((revista:revista)=>{
    //   this.revistaR=revista;
    // })

}

}