import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {Register} from 'ts-node';

@Component({
  selector: 'app-ss6-register',
  templateUrl: './ss6-register.component.html',
  styleUrls: ['./ss6-register.component.css']
})
export class Ss6RegisterComponent implements OnInit {
  registerForm: FormGroup = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', Validators.required),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [this.regexAge]),
      gender: new FormControl(''),
      phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')])
    },
    this.comparePassword);
  register: Register;

  registerNew: Register[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  submit() {
    this.register = this.registerForm.value;
    this.registerNew.push(this.register);
    console.log(this.registerNew);
  }

  comparePassword(c: AbstractControl) {
    const v = c.value;
    return (v.password === v.confirmPassword) ?
      null : {
        passWordNotMatch: true
      };
  }


  regexAge(control: AbstractControl): ValidationErrors | null {
    const a = control.value;
    const current = new Date().getFullYear();
    const birthday = new Date(a).getFullYear();
    const age = current - birthday;
    if (isNaN(age)) {
      return {ageFalse: true};
    }
    if (age < 18) {
      return {ageFalse: true};
    }
    return null;
  }
}
