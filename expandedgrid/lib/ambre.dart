import 'package:flutter/material.dart';

import 'main.dart';

class Ambre extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'Formulaire avec Validation', home: MyFormPage());
  }
}

class MyFormPage extends StatefulWidget {
  @override
  _MyFormPageState createState() => _MyFormPageState();
}

class _MyFormPageState extends State<MyFormPage> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _mailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _password2Controller = TextEditingController();

  // Ajouter autres Controllers plus tard...

  @override
  void dispose() {
    _nameController.dispose();
    _mailController.dispose();
    _passwordController.dispose();
    _password2Controller.dispose();

    // autres controllers....
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Formulaire'),

        flexibleSpace: ShaderMask(
          shaderCallback:
              (bounds) => LinearGradient(
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
                colors: [
                  Colors.black.withValues(alpha: 0.2),
                  Colors.white.withValues(alpha: 0.2),
                ],
              ).createShader(bounds),
          blendMode: BlendMode.softLight,
          child: Container(color: Colors.amber),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.amber,
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => MyApp()),
          );
        },
        child: Icon(Icons.arrow_back),
      ),

      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                // maxLength: 255,
                controller: _nameController,
                decoration: InputDecoration(
                  labelText: 'Nom',
                  hintText: 'Entrez votre nom ici',
                  border: OutlineInputBorder(),
                ),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Veuillez saisir votre nom';
                  }

                  return null;
                },
              ),

              SizedBox(height: 20),

              TextFormField(
                controller: _mailController,
                decoration: InputDecoration(
                  labelText: 'E-mail',
                  hintText: 'Entrez votre adresse e-mail ici',
                  border: OutlineInputBorder(),
                ),

                keyboardType: TextInputType.emailAddress,

                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Veuillez saisir votre adresse e-mail';
                  }

                  if (!RegExp(
                    r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$',
                  ).hasMatch(value)) {
                    return 'Veuillez saisir une adresse e-mail valide';
                  }

                  return null;
                },
              ),

              SizedBox(height: 20),

              TextFormField(
                controller: _passwordController,
                decoration: InputDecoration(
                  labelText: 'Mot de passe',
                  hintText:
                      'Entrez un mot de passe d\'au moins 8 caractères ici',
                  border: OutlineInputBorder(),
                ),

                obscureText: true,

                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Veuillez saisir votre mot de passe';
                  }

                  if (value.length < 8) {
                    return 'Votre mot de passe n\'a pas au moins 8 caractères.';
                  }

                  return null;
                },
              ),

              SizedBox(height: 20),

              TextFormField(
                controller: _password2Controller,
                decoration: InputDecoration(
                  labelText: 'Mot de passe',
                  hintText:
                      'Entrez un mot de passe d\'au moins 8 caractères ici',
                  border: OutlineInputBorder(),
                ),

                obscureText: true,

                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Veuillez confirmer votre mot de passe';
                  }

                  if (_passwordController.value != _password2Controller.value) {
                    return 'Les deux mots de passes sont différents';
                  }

                  return null;
                },
              ),

              SizedBox(height: 20),

              ElevatedButton(
                onPressed: () {
                  // Validation du formulaire
                  if (_formKey.currentState!.validate()) {
                    // Affichage des résultats dans ma snackBar
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text(
                          'Formulaire validé ! \n'
                          'Nom : ${_nameController.text} \n'
                          'Email : ${_mailController.text} \n'
                          'Mot de passe : ${_passwordController.text} \n'
                          'Confirmation du mot de passe : ${_password2Controller.text} \n',
                        ),
                        duration: Duration(seconds: 3),
                        action: SnackBarAction(
                          label: 'Ok',
                          onPressed: () {
                            ScaffoldMessenger.of(context).hideCurrentSnackBar();
                          },
                        ),
                      ),
                    );
                  }
                },
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsets.symmetric(vertical: 15, horizontal: 30),
                  backgroundColor: Colors.amberAccent[50],
                  foregroundColor: Colors.amber,
                ),
                child: Text('Valider'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
