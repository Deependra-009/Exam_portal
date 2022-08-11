import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  logindata={
    username:'',
    password:''
  }

  constructor(
    private mat:MatSnackBar,
    private loginservice:LoginserviceService
  ) { }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.logindata);

    if(this.logindata.username.trim()=='' || this.logindata.username==null){
      this.mat.open("Username is required!!!",'',{
        duration:3000,
      });
      return;
    }
    else if(this.logindata.password.trim()=='' || this.logindata.password==null){
      this.mat.open("Passwored is required!!!",'',{
        duration:3000,
      });
      return;
    }

    this.loginservice.generateToken(this.logindata).subscribe(
      (data:any)=>{
        console.log(data.token);
        
        // Login...
        this.loginservice.loginuser(data.token);

        // get current user

        this.loginservice.getCurrentUser().subscribe(
          (userdata:any)=>{
            this.loginservice.setUser(userdata);

            // redirect ... ADMIN:admin-dashboard
            // redirect ... NORMAL :normal-dashboard

            if(this.loginservice.getUserRole()=="ADMIN"){
              // admin dashboard
              window.location.href='/admin'
            } 
            else if(this.loginservice.getUserRole()=="NORMAL"){
              // normal dashboard
              window.location.href='/user'
            }
            
           
          },
          (error)=>{
            console.log(error);
            this.loginservice.logggedout();
            window.location.href='/login'
            this.mat.open("Invalid Details !!")
          }
        )

      },
      (error)=>{
        console.log(error) ;
        this.mat.open("Invalid Details !!")
      }
    )
    
    
    
  }

}
