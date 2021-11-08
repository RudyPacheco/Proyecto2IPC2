import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { anuncioService } from 'src/app/services/anuncio/anuncio.service';
import { etiquetasService } from 'src/app/services/informacion/etiquetas.service';
import { anuncioModel } from 'src/models/anuncio/anuncio.model';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-form-anuncio-video',
  templateUrl: './form-anuncio-video.component.html',
  styleUrls: ['./form-anuncio-video.component.css']
})
export class FormAnuncioVideoComponent implements OnInit {

  anuncioForm!:FormGroup;
  fechaI='';
  etiquetas!:string[];
  tagsSelected:string[]=[];
  anuncioM!:anuncioModel;

  constructor(private builder:FormBuilder,private tagService:etiquetasService,private anuncioService:anuncioService,private router:Router) {
    this.anuncioForm=this.builder.group({
      anunciante:['',Validators.required],
      video:['',Validators.required],
      cantidadDias:['',Validators.required],
      etiquetaS:['',Validators.required],

    })

   }



  public modificarFechaI(event: Event) {
    this.fechaI = (<HTMLInputElement>event.target).value;
  }
  registrarAnuncio(){
//1 texto 2 imagen 3 video

    console.log(this.anuncioForm.value);
    console.log(this.fechaI);
    this.anuncioM=this.anuncioForm.value;
    this.anuncioM.etiquetas=this.tagsSelected;
    this.anuncioM.fechaPublicacion=this.fechaI;
    this.anuncioM.tipoAnuncio=3;


    console.log(this.anuncioM);

    this.anuncioService.generarRegistro(this.anuncioM).subscribe((data)=>{
      console.log("se envio al bakend");
      this.popAfirmation();
      this.router.navigate(['InicioAdmin']);

    },
    (error: any)=>{
      console.log("error");
      this.popErro();
    }
    );


  }

  ngOnInit(): void {
    this.tagService.getEtiquetas().subscribe((tags:string[])=>{
      //this.options=this.options.concat(tags);
      this.etiquetas=tags;
    });
  }

  agregar(){
    console.log(this.anuncioForm.get("etiquetaS")?.value);
    var indice = this.tagsSelected.indexOf(this.anuncioForm.get("etiquetaS")?.value);
    if (indice==-1) {
     this.tagsSelected.push(this.anuncioForm.get("etiquetaS")?.value);
    }

  }


  public popAfirmation(){
    Swal.fire(
      'Anuncio Publicado',
      'Se comenzara a mostrar',
      'success'
    )
  }
  
  public popErro(){
    Swal.fire(
      'Error',
      'Ocurrio algun error',
      'error'
    )
  }

}
