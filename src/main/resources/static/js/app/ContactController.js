angular.module('contactsApp').controller('ContactController',
    ['ContactService', '$scope',  function( ContactService, $scope) {

        var self = this;
        self.contact = {};
        self.contacts=[];
        self.today = new Date();

        self.getAllContacts = getAllContacts;
        self.editContact = editContact;
        self.updateContact = updateContact;
        self.removeContact = removeContact;
        self.addContact = addContact;

        function getAllContacts(){
            return ContactService.getAllContacts();
        }

        function editContact(id) {
                    ContactService.getContact(id).then(
                        function (contact) {
                            contact.birthDay = new Date(contact.birthDay);
                            self.contact = contact;
                        },
                        function (errResponse) {
                            console.error('Error : ' + errResponse.data);
                        }
                    );
        }

        function updateContact(){
            if (self.contact.id) {
                ContactService.updateContact(self.contact, self.contact.id).then(
                        function (response){
                        },
                        function(errResponse){
                        }
                );
            } else {
                ContactService.createContact(self.contact).then(
                        function (contact){
                            self.contact = contact;
                        },
                        function(errResponse){
                        }
                );
            }
        }

        function removeContact(id){
                    ContactService.removeContact(id)
                        .then(
                            function(){
                            },
                            function(errResponse){
                            }
                        );
        }

        function addContact() {
            self.contact=ContactService.getNewContact();
        }

    }


    ]);