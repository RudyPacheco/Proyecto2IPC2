import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { edicionService } from 'src/app/services/revista/edicion.service';
import { revista } from 'src/models/revista/revista.model';

@Component({
  selector: 'app-form-edicion',
  templateUrl: './form-edicion.component.html',
  styleUrls: ['./form-edicion.component.css']
})
export class FormEdicionComponent implements OnInit {

  selectedFile: File | null = null;

  revistaSelect:revista;
  edicionForm:FormGroup;



  constructor(private edicionService:edicionService,private builder:FormBuilder,private router:Router) {
    this.revistaSelect=this.edicionService.revistaSelect;
    this.edicionForm=this.builder.group({
      fechaCreacion:['',Validators.required]
    })
   }

  fileUploadInAngular(event: Event) {
    const files = (event.target as  HTMLInputElement).files;
    if (files != null) {
      this.selectedFile = files.item(0);
    }
  }



  publicarEdicion(){
    if (this.edicionForm.valid && this.selectedFile!==null)  {
      this.revistaSelect.fechaCreacion=this.edicionForm.get("fechaCreacion")?.value;
     
      this.edicionService.generarRegistro(this.revistaSelect).subscribe((data)=>{
        this.guardarArchivo();
      })
    }
  }


  guardarArchivo(){
    if (this.selectedFile!==null) {
      this.edicionService.guardarRevista(this.selectedFile).subscribe((data)=>{
        console.log("edicion enviada");
        this.router.navigate(['Edicones']);
      })
    }

  }


  ngOnInit(): void {
  }

}
