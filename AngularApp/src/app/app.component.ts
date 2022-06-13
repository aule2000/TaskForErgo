import {Component, Input, OnInit} from '@angular/core';
import {Person} from './person';
import {DatePipe} from '@angular/common';
import {PersonService} from './person.service';
import {Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'AngularApp';

  persons : Person[];
  pipe = new DatePipe('en-US');

  myForm: FormGroup;
  constructor(
    private personService: PersonService,
    private fb: FormBuilder
  )  {  }
  ngOnInit() {
    this.myForm = this.fb.group({
      personalCode: ['',[Validators.required,Validators.minLength(11), Validators.maxLength(11)]],
      birthDate: ['',[Validators.required, Validators.pattern("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")]]
    });
  }


  onSubmit(form: FormGroup) {
    console.log('Valid?', form.valid);
      this.personService.getPersonByPersonalCodeAndBirthDate(form.value.personalCode,form.value.birthDate)
        .subscribe(data => {

          this.persons = data;
          this.persons.forEach(x =>
            x.birthDate = this.pipe.transform(x.birthDate, 'yyyy-MM-dd'));
        });
  }






}
