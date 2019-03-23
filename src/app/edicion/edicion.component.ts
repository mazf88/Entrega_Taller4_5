import { Component, OnInit } from '@angular/core';
import { usuario } from '../Module/usuario';
import { containerRefreshEnd } from '@angular/core/src/render3';

@Component({
  selector: 'app-edicion',
  templateUrl: './edicion.component.html',
  styleUrls: ['./edicion.component.css']
})
export class EdicionComponent implements OnInit {

  miusuario: usuario;

  constructor() {
    this.miusuario = {
      nombre: "Diego",
      telefono: 311222,
      correo: 'd@cr',
      usuario: 'drr'
      };
     
   }

  ngOnInit() {
  }

}
