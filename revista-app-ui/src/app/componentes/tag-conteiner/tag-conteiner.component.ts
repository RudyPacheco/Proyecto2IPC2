
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { tap } from 'rxjs/operators';
import { registroServices } from 'src/app/services/registro/registro.service';
import { UsuarioNuevo } from 'src/models/register/newUsuario';


@UntilDestroy()
@Component({
  selector: 'app-tag-conteiner',
  templateUrl: './tag-conteiner.component.html',
  styleUrls: ['./tag-conteiner.component.css']
})
export class TagConteinerComponent  {

  constructor(private registreService:registroServices, private router:Router){}


  options = ['Tecnologia', 'Hogar', 'Electronica', 'Libro', 'Naturaleza','Trabajo', 'Naturaleza', 'Familia', 'Economia'];

  chipsControl = new FormControl();

  chipsControlValue$ = this.chipsControl.valueChanges;

  disabledControl = new FormControl(false);

  

  imprimir(){
  //  let newUsurio =this.registreService.getUsuario().Nombre;
    console.log(this.registreService.getUsuario().Nombre);
    console.log(this.chipsControl.value);
    this.router.navigate(['login']);
  }

  setChipsValue() {
    this.chipsControl.setValue(['Shoes', 'Electronics']);
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
