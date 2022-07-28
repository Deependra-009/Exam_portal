import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private userService:UserService,
    private snack:MatSnackBar
  ) { }

  public user={
    username:'',
    password:'',
    firstname:'',
    lastname:'',
    email:'',
    phone:''
  }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log("hello");
    console.log(this.user);
    
    this.userService.addUser(this.user).subscribe(
      (data)=>{
        console.log(data);
        console.log("success");
        Swal.fire('Success','Registered Successfully','success')
        
        
      },
      (error)=>{
        console.log(error);
        // this.snack.open("Something is wrong!!","oK");
        Swal.fire('Error','Something is wrong','error')
      }
    )

    
  }

}
