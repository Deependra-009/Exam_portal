import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn=false;
  constructor(
    public login:LoginserviceService
  ) { 
    
  }

  ngOnInit(): void {
  
  }

  loggedout(){
    this.login.logggedout();
    
  }

  

  

}
