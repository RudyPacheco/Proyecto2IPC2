import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BootstrapIcons } from 'ng-bootstrap-icons/bootstrap-icons/ng-bootstrap-icons.component';
import { BootstrapIconsModule } from 'ng-bootstrap-icons';
import { Icons } from 'ng-bootstrap-icons/bootstrap-icons/icons.provider';
import {Alarm} from 'ng-bootstrap-icons/icons'

const icons = {
  Alarm
};


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    BootstrapIconsModule.pick(icons)
  ]
})
export class IconsModule { }
