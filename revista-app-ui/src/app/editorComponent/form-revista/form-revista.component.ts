import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { etiquetasService } from 'src/app/services/informacion/etiquetas.service';
import { loginServices } from 'src/app/services/login/login.services';
import { registroServices } from 'src/app/services/registro/registro.service';
import { revistaService } from 'src/app/services/revista/revista.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-form-revista',
  templateUrl: './form-revista.component.html',
  styleUrls: ['./form-revista.component.css']
})
export class FormRevistaComponent implements OnInit {

  selectedFile: File | null = null;
  revistaNueva!: revista;
  options = ['Tecnologia','Economia'];
  categorias!:string[];
  etiquetas!:string[];
  tagsSelected:string[]=[];
  revistaForm!:FormGroup;
  

  constructor(private router:Router ,private loginService:loginServices,private revistaService: revistaService,private tagService:etiquetasService, private builder:FormBuilder) { 
   this.revistaForm = this.builder.group({
     nombreRevista:['',Validators.required],
     categoria:[null,Validators.required],
     etiquetaS:['',Validators.required],
     etiquetaCustom:[''],
     precioRevista:['',Validators.required],
     descripcion:['',Validators.required],
     fechaCreacion:['',Validators.required],
     editor:[this.loginService.getUsuario().usuario]
   })

  }



  ngOnInit(): void {
    this.tagService.getEtiquetas().subscribe((tags:string[])=>{
      //this.options=this.options.concat(tags);
      this.etiquetas=tags;
    });
    this.tagService.getCategorias().subscribe((categorias:string[])=>{
      this.categorias=categorias;
    })

  }

  fileUploadInAngular(event: Event) {
    const files = (event.target as  HTMLInputElement).files;
    if (files != null) {
      this.selectedFile = files.item(0);
    }
  }

  prueba(){
    console.log(this.revistaForm.value);
  }

  agregar(){
    console.log(this.revistaForm.get("etiquetaS")?.value);
    var indice = this.tagsSelected.indexOf(this.revistaForm.get("etiquetaS")?.value);
    if (indice==-1) {
     this.tagsSelected.push(this.revistaForm.get("etiquetaS")?.value);
    }
 
    console.log(this.tagsSelected);
  
  }

  agregarCustom(){
    console.log(this.revistaForm.get("etiquetaCustom")?.value);
    var indice = this.tagsSelected.indexOf(this.revistaForm.get("etiquetaCustom")?.value);
    if (indice==-1) {
     this.tagsSelected.push(this.revistaForm.get("etiquetaCustom")?.value);
    }
    this.revistaForm.reset({
      etiquetaCustom: ''
 
    });
    console.log(this.tagsSelected);
  
  }


  publicarRevista(){
    if (this.revistaForm.valid && this.selectedFile!==null) {
      this.revistaNueva=this.revistaForm.value;
      this.revistaNueva.etiquetas=this.tagsSelected;
      this.revistaNueva.interaccion=true;
      console.log(this.revistaNueva);
      this.revistaService.generarRegistro(this.revistaNueva).subscribe((data)=>{
        console.log("revista registada")
        this.enviarRevista();
      })
    }
  }

  enviarRevista(){
    if (this.selectedFile!==null) {
      this.revistaService.guardarRevista(this.selectedFile).subscribe((data)=>{
        console.log("revista enviada")
        this.router.navigate(['inicioED']);
      })
    }
  }




  imprimir(){

    // if (this.selectedFile != null) {
    //  this.revistaP= new revista("revista1",10,"descripcion xd","categoriaxd",this.options);      
    //   console.log(this.revistaP);
    //   this.revistaService.guardarRevista(this.selectedFile).subscribe((data)=>{
    //     console.log("archivo enviado")
    //   },
    //   (error: any)=>{
    //     console.log("error al subir archivo")
    //   }
    //   );

    //   this.revistaService.generarRegistro(this.revistaP).subscribe((create:revista)=>{
    //     console.log(create);
    //   });
    // }


  }



}
