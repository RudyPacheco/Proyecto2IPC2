
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { tap } from 'rxjs/operators';
import { etiquetasService } from 'src/app/services/informacion/etiquetas.service';
import { registroServices } from 'src/app/services/registro/registro.service';
import { UsuarioNuevo } from 'src/models/register/newUsuario';
import { UsuarioTag } from 'src/models/register/usaurioTags';
import {MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';

@UntilDestroy()
@Component({
  selector: 'app-tag-conteiner',
  templateUrl: './tag-conteiner.component.html',
  styleUrls: ['./tag-conteiner.component.css']
})
export class TagConteinerComponent  {

  usuarioInfo!: UsuarioTag;
  options!:string[];
  seleccionados!:string[]
  constructor(private registreService:registroServices, private router:Router,private tagsService: etiquetasService){
    this.tagsService.getEtiquetas().subscribe((tags:string[])=>{
      //this.options=this.options.concat(tags);
      this.options=tags;
    });
  }


 // options = ['Tecnologia', 'Hogar', 'Electronica', 'Libro', 'Naturaleza','Trabajo', 'Naturaleza', 'Familia', 'Economia'];
  
  

  chipsControl = new FormControl();

  chipsControlValue$ = this.chipsControl.valueChanges;

  disabledControl = new FormControl(false);

  agregar(tag:string){
    this.seleccionados.push(tag);
  }



  imprimir(){

    console.log(this.options);
    //  let newUsurio =this.registreService.getUsuario().Nombre;
  //  console.log(this.registreService.getUsuario());
    console.log(this.chipsControl.value);
    console.log(this.seleccionados)

   //  this.usuarioInfo = new UsuarioTag(this.registreService.getUsuario().nombre,this.chipsControl.value);
  //   console.log(this.usuarioInfo);
  //   this.registreService.guardarInteres(this.usuarioInfo).subscribe((create: UsuarioTag)=>{


     
  //     console.log(create)
  //    this.router.navigate(['login']);


  //   },
  //   (error: any)=>{

  //   }
  //   );
 //   this.router.navigate(['login']);
  }



  ngOnInit() {
   

    this.disabledControl.valueChanges
      .pipe(untilDestroyed(this))
      .subscribe((val) => {
        if (val) this.chipsControl.disable();
        else this.chipsControl.enable();
      });
  }
}
