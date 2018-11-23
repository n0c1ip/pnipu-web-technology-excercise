<div class="navbar navbar-dark bg-dark">
  <span class="navbar-brand">Список контактов</span>
</div>
<div class="panel-body">
  <div class="table-responsive">
    <table class="table table-hover">
	  <thead>
	    <tr>
		  <th>ИМЯ</th>
		  <th>ФАМИЛИЯ</th>
		  <th>ТЕЛЕФОН</th>
		  <th>ПОЧТА</th>
		  <th>ДАТА РОЖДЕНИЯ</th>
		  <th width="100"></th>
		  <th width="100">
		    <button type="button" ng-click="ctrl.addContact()" class="btn btn-info"  data-toggle="modal" data-target="#contactEdit">Добавить</button>
		  </th>
		</tr>
	  </thead>
	  <tbody>
	    <tr ng-repeat="c in ctrl.getAllContacts()">
		  <td>{{c.firstName}}</td>
		  <td>{{c.secondName}}</td>
		  <td>{{c.phone}}</td>
		  <td>{{c.email}}</td>
		  <td>{{c.birthDay | date: 'dd.MM.yyyy'}}</td>
		  <td><button type="button" ng-click="ctrl.editContact(c.id)" class="btn btn-success custom-width" data-toggle="modal" data-target="#contactEdit">Редактировать</button></td>
		  <td><button type="button" ng-click="ctrl.removeContact(c.id)" class="btn btn-danger custom-width">Удалить</button></td>
		</tr>
	  </tbody>
	</table>
  </div>
</div>

<div id="contactEdit" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">{{!ctrl.contact.id ? 'Добавление' : 'Редактирование'}} конаткта</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <form name="contactForm" class="modal-body">
        <div class="form-group">
          <label for="firstName">Имя:</label>
          <input type="text" ng-model="ctrl.contact.firstName" class="form-control" id="firstName" name="firstName" required>
          <span style="color:red" ng-show="contactForm.firstName.$dirty && contactForm.firstName.$invalid">
                <span ng-show="contactForm.firstName.$error.required">Поле "Имя" является обязательным.</span>
          </span>
        </div>
        <div class="form-group">
          <label for="secondName">Фамилия:</label>
          <input type="text" ng-model="ctrl.contact.secondName" class="form-control" id="secondName" name="secondName" required>
          <span style="color:red" ng-show="contactForm.secondName.$dirty && contactForm.secondName.$invalid">
                <span ng-show="contactForm.secondName.$error.required">Поле "Фамилия" является обязательным.</span>
          </span>
        </div>
        <div class="form-group">
          <label for="phone">Телефон:</label>
          <input type="text" ng-model="ctrl.contact.phone" class="form-control" id="phone">
        </div>
        <div class="form-group">
          <label for="email">Почта: </label>
          <input name="email" type="email" ng-model="ctrl.contact.email" class="form-control" id="email" name="email">
          <span style="color:red" ng-show="contactForm.email.$invalid">
                <span ng-show="contactForm.email.$invalid">Не верный формат e-mail</span>
          </span>
        </div>
        <div class="form-group">
          <label for="birthDay">Дата рождения:</label>
          <input type="date" ng-model="ctrl.contact.birthDay" max="{{ ctrl.today | date:'yyyy-MM-dd' }}" class="form-control" id="birthDay">
        </div>
      </form>
      <div class="modal-footer">
        <button type="button"
        ng-disabled="contactForm.firstName.$dirty && contactForm.firstName.$invalid ||
                     contactForm.secondName.$dirty && contactForm.secondName.$invalid"
        ng-click="ctrl.updateContact()" class="btn btn-primary" data-dismiss="modal">Сохранить</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
      </div>
    </div>
  </div>
</div>