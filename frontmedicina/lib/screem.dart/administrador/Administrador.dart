import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Administrador(),
    );
  }
}

class Administrador extends StatefulWidget {
  @override 
  _AdministradorState createState() => _AdministradorState();
}

class _AdministradorState extends State<Administrador> {
  String? selectedScreen; // Variable para manejar la pantalla actual

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue[800],
        title: Row(
          children: [
           Image.asset('assets/saitel_log.jpg', height: 50),
        
          ],
        ),
        actions: [
          Row(
            children: [
              Text('admin', style: TextStyle(color: Colors.white, fontSize: 16)),
              SizedBox(width: 10),
              Icon(Icons.person, color: Colors.white),
              SizedBox(width: 15),
            ],
          ),
        ],
      ),
      drawer: MediaQuery.of(context).size.width < 600
          ? Drawer(
              child: ListView(
                padding: EdgeInsets.zero,
                children: [
                  DrawerHeader(
                    decoration: BoxDecoration(
                      color: Colors.blue[800],
                    ),
                    child: Row(
                      children: [
                        Image.asset('assets/saitel_logo.jpg', height: 40),
                      ],
                    ),
                  ),
                  NavigationPanel(onItemSelected: _updateScreen),
                ],
              ),
            )
          : null,
      body: LayoutBuilder(
        builder: (context, constraints) {
          bool isLargeScreen = constraints.maxWidth >= 600;
          return Row(
            children: [
              if (isLargeScreen)
                NavigationPanel(onItemSelected: _updateScreen),
              Expanded(
                child: Container(
                  padding: EdgeInsets.all(16),
                  color: Colors.white,
                  child: _buildScreen(),
                ),
              ),
            ],
          );
        },
      ),
    );
  }

  void _updateScreen(String screenKey) {
    setState(() {
      selectedScreen = screenKey == "Inicio" ? null : screenKey;
    });
  }

  Widget _buildScreen() {
    if (selectedScreen == "HCU 0777 - Formulario de evaluación preocupacional") {
      return EvaluacionPreocupacionalScreen();
    } else {
      return Center(child: Text("Bienvenido", style: TextStyle(fontSize: 20)));
    }
  }
}

class NavigationPanel extends StatefulWidget {
  final Function(String) onItemSelected;
  NavigationPanel({required this.onItemSelected});

  @override
  _NavigationPanelState createState() => _NavigationPanelState();
}

class _NavigationPanelState extends State<NavigationPanel> {
  bool isMedicinaExpanded = false;
  bool isPsicologiaExpanded = false;
  String? selectedItem; // Almacena la opción seleccionada..

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width * 0.25,
      color: Colors.blue[800],
      child: buildMenu(),
    );
  }

  Widget buildMenu() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        buildMenuItem(Icons.home, "Inicio", false, () {
          setState(() {
            selectedItem = "Inicio";
          });
          widget.onItemSelected("Inicio");
        }),
        SizedBox(height: 10),
        buildMenuItem(Icons.local_hospital, "Medicina", isMedicinaExpanded, () {
          setState(() {
            isMedicinaExpanded = !isMedicinaExpanded;
          });
        }),
        if (isMedicinaExpanded)
          ...buildSubMenuItems([
            "HCU 0777 - Formulario de evaluación preocupacional",
            "HCU 079 - Formulario de evaluación de reintegro",
            "HCU 078 - Formulario de evaluación periódica", 
            "HCU 080 - Formualrio de evaluación de retiro",
            "HCU 081 - Certificado de salud en el Trabajo",
            "HCU 083 - Registro de inmunizaciones para salud en el trabajo",
          ]),
        buildMenuItem(Icons.psychology, "Psicología", isPsicologiaExpanded, () {
          setState(() {
            isPsicologiaExpanded = !isPsicologiaExpanded;
          });
        }),
      ],
    );
  }

  Widget buildMenuItem(IconData icon, String title, bool isExpanded, VoidCallback onTap) {
    return Container(
      color: selectedItem == title ? Colors.orange : Colors.blue[700],
      child: ListTile(
        leading: Icon(icon, color: Colors.white),
        title: Text(title, style: TextStyle(color: Colors.white)),
        trailing: Icon(isExpanded ? Icons.expand_less : Icons.expand_more, color: Colors.white),
        onTap: onTap,
      ),
    );
  }

  List<Widget> buildSubMenuItems(List<String> items) {
    return items.map((title) {
      return Padding(
        padding: const EdgeInsets.only(left: 10.0),
        child: Container(
          color: selectedItem == title ? Colors.orange : Colors.blue[600],
          child: ListTile(
            leading: Icon(Icons.play_arrow, color: Colors.white),
            title: Text(title, style: TextStyle(color: Colors.white)),
            onTap: () {
              setState(() {
                selectedItem = title;
              });
              widget.onItemSelected(title);
            },
          ),
        ),
      );
    }).toList();
  }
}

class EvaluacionPreocupacionalScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          children: [
            Expanded(
              child: DropdownButtonFormField( 
                decoration: InputDecoration(labelText: "Sucursal"),
                items: ["EMPRESA"].map((e) => DropdownMenuItem(value: e, child: Text(e))).toList(),
                onChanged: (value) {},
              ),
            ),
            SizedBox(width: 10),
            Expanded(
              child: DropdownButtonFormField(
                decoration: InputDecoration(labelText: "Departamento"),
                items: ["MEDICO"].map((e) => DropdownMenuItem(value: e, child: Text(e))).toList(),
                onChanged: (value) {},
              ),
            ),
            SizedBox(width: 10),
            Expanded(
              child: TextField(
                decoration: InputDecoration(labelText: "Fecha Inicio"),
              ),
            ),
          ],
        ),
        SizedBox(height: 10),
        Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            ElevatedButton(
              onPressed: () {},
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.blue[800],
                foregroundColor: Colors.white,
              ),
              child: Text("Filtrar"),
            ),
            SizedBox(width: 10),
            TextButton.icon(
              onPressed: () {
                _showFormSelectionDialog(context);
              },
              icon: Icon(Icons.add),
              label: Text("Nuevo Formulario"),
            ),
          ],
        ),
        SizedBox(height: 20),
        Container(
          color: Colors.blue[800],
          padding: EdgeInsets.all(10),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text("#", style: TextStyle(color: Colors.white)),
              Text("Medico", style: TextStyle(color: Colors.white)),
              Text("Paciente", style: TextStyle(color: Colors.white)),
              Text("Fecha", style: TextStyle(color: Colors.white)),
            ],
          ),
        ),
        Expanded(child: Container(color: Colors.white)),
      ],
    );
  }

  void _showFormSelectionDialog(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        String? selectedForm;
        String? selectedPatient;

        return Dialog(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(15),
          ),
          elevation: 8,
          child: Container(
            padding: const EdgeInsets.all(15),
            constraints: BoxConstraints(maxWidth: 400),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  "Seleccionar Formulario",
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Colors.blue[800],
                  ),
                ),
                SizedBox(height: 10),
                DropdownButtonFormField<String>(
                  decoration: InputDecoration(
                    labelText: "Tipo de Formulario",
                    filled: true,
                    fillColor: Colors.blue[50],
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                      borderSide: BorderSide.none,
                    ),
                  ),
                  items: [
                    "Formulario A",
                    "Formulario B",
                    "Formulario C",
                  ].map((form) {
                    return DropdownMenuItem<String>(
                      value: form,
                      child: Text(form),
                    );
                  }).toList(),
                  onChanged: (value) {
                    selectedForm = value;
                  },
                ),
                SizedBox(height: 10),
                TextField(
                  decoration: InputDecoration(
                    labelText: "Paciente",
                    filled: true,
                    fillColor: Colors.blue[50],
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                      borderSide: BorderSide.none,
                    ),
                  ),
                  onChanged: (value) {
                    selectedPatient = value;
                  },
                ),
                SizedBox(height: 15),
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    TextButton(
                      onPressed: () {
                        Navigator.of(context).pop();
                      },
                      child: Text("Cancelar", style: TextStyle(color: Colors.blue[800])),
                    ),
                    SizedBox(width: 10),
                    ElevatedButton(
                      onPressed: () {
                        if (selectedForm != null && selectedPatient != null) {
                          Navigator.of(context).pop();
                          A_EmpresaYusuario(context);
                        }
                      },
                      child: Text("Aceptar"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        );
      },
    );
  }

  void A_EmpresaYusuario(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return Dialog(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
          child: Padding(
            padding: const EdgeInsets.all(20),
            child: SingleChildScrollView(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Center(
                    child: Text(
                      "A. DATOS DEL ESTABLECIMIENTO EMPRESA Y USUARIO",
                      style: TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.bold,
                        color: Colors.blue[800],
                      ),
                    ),
                  ),
                  SizedBox(height: 20),
                  Wrap(
                    spacing: 20,
                    runSpacing: 15,
                    children: [
                      buildInputField("INSTITUCION DEL SISTEMA O NOMBRE DE LA EMPRESA"),
                      buildInputField("RUC"),
                      buildInputField("CIUDAD"),
                      buildInputField("ESTABLECIMIENTO DE SALUD"),
                      buildInputField("NOMBRE DE HISTORIA CLINICA"),
                      buildInputField("NUMERO DE ARCHIVO"),
                      buildInputField("NOMBRES"),
                      buildInputField("APELLIDOS "),
                      buildDropdownField("GENERO", ["Femenino","Masculino"]),
                      buildInputField("GRUPO SANGUINEO"),
                      buildInputField("LATERALIDAD"),
                      buildDropdownField("ORIENTACION SEXUAL", ["Lesbiana", "Gay", "Bisexual", "Heterosexual", "No sabe"]),
                        buildInputField("DISCAPACIDAD"),
                          buildInputField("FECHA DE INGRESO AL TRABAJO"),
                            buildInputField("PUESTO DE TRABAJO"),
                              buildInputField("AREA DE TRABAJO"),
                                buildInputField("ACTIVIDADES DEL AREA DE TRABAJO"),
                 //    buildDropdownField("Tipo de Evaluación", [
                 //       "Preocupacional",
//"Periódica",
//"Reintegro",
//"Retiro"
//], fullWidth: true),
                    ],
                  ),
                  SizedBox(height: 30),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      TextButton(
                        onPressed: () => Navigator.of(context).pop(),
                        child: Text("Cancelar"),
                      ),
                      SizedBox(width: 10),
                      ElevatedButton(
                        onPressed: () {
                          Navigator.of(context).pop();
                        },
                        child: Text("Guardar"),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.blue[800],
                          foregroundColor: Colors.white,
                        ),
                      ),

                           ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          B_MotivoConsulta(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        );
      },
    );
  }


  void B_MotivoConsulta(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return Dialog(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
          child: Padding(
            padding: const EdgeInsets.all(20),
            child: SingleChildScrollView(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Center(
                    child: Text(
                      "B. MOTIVO CONSULTA",
                      style: TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.bold,
                        color: Colors.blue[800],
                      ),
                    ),
                  ),
                  SizedBox(height: 20),
                  Wrap(
                    spacing: 20,
                    runSpacing: 15,
                    children: [
                      
                                buildInputField("ACTIVIDADES DEL AREA DE TRABAJO"),
                    //  buildDropdownField("Tipo de Evaluación", [
                 //       "Preocupacional",
//"Periódica",
//"Reintegro",
//"Retiro"
//], fullWidth: true),
                    ], 
                  ),
                  SizedBox(height: 30),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      TextButton(
                        onPressed: () => Navigator.of(context).pop(),
                        child: Text("Cancelar"),
                      ),
                      SizedBox(width: 10),
                      ElevatedButton(
                        onPressed: () {
                          Navigator.of(context).pop();
                        },
                        child: Text("Guardar"),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.blue[800],
                          foregroundColor: Colors.white,
                        ),
                      ),

                         ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          C_AntecedentesPersonales(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        );
      },
    );
  }


  void C_AntecedentesPersonales(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              
              "C. ANTECEDENTES PERSONALES",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold,),
              
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("ANTECEDENTES GINECO OBSTÉTRICOS", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(120),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('MENARQUIA'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CICLOS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FUM'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('GESTAS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PARTOS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CESÁREAS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('ABORTOS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('HIJOS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PLANIFICACIÓN'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TIPO MÉTODO'))),
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              10,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    const SizedBox(height: 24),
                    const Text("ANTECEDENTES REPRODUCTIVOS MASCULINOS", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(200),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('EXAMENES REALIZADOS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TIEMPO'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('RESULTADOS'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('METODO DE PLANIFICACION FAMILIAR'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TIPO DE METODO'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('HIJOS'))),
                           
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              6,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    // TABLA 3


                           const SizedBox(height: 24),
                    const Text("HABITOS TOXICOS", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(200),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CONSUMO NOCIVO'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TIEMPO DE CONSUMO'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CANTIDAD'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('EX CONSUMIDOR'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TIEMPO DE ABSTINENCIA'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('ACTIVIDAD FISICA'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CUAL ACTIVIDAD'))),
                           
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              7,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),

              
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          D_AntecedentesTrabajo(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }





   void D_AntecedentesTrabajo(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "D. ANTECEDENTES DE TRABAJO",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("ANTECEDENTES DE EMPLEOS ANTERIORES", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(200),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('EMPRESA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PUESTO DE TRABAJO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('ANTECEDENTES QUE DESEMPEÑABA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TIEMPO DE TRABAJO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('RIESGO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('OBSERVACIONES'))),
        ],
      ),
      TableRow(
        children: [
          // EMPRESA
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // PUESTO DE TRABAJO
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // ANTECEDENTES QUE DESEMPEÑABA
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // TIEMPO DE TRABAJO
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // RIESGO - CAMBIO A COMBOBOX
          Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Físico', child: Text('Físicoo')),
                DropdownMenuItem(value: 'Mecánico', child: Text('Mecánico')),
                DropdownMenuItem(value: 'Químico', child: Text('Químico')),
                DropdownMenuItem(value: 'Biológico', child: Text('Biológico')),
                DropdownMenuItem(value: 'Ergonómico', child: Text('Ergonómico')),
                DropdownMenuItem(value: 'Psicosocial', child: Text('Psicosocial')),
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),

          // OBSERVACIONES
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),
        ],
      ),
    ],
  ),
),

                    const SizedBox(height: 24),
                    const Text("ACCIDENTES DE TRABAJO", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(500),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CALIFICADO POR EL INSTITUTO DE SEGURIDAD SOCIAL'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FECHA'))),
                    
                           
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              2,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    // TABLA 3


                           const SizedBox(height: 24),
                    const Text("ENFERMEDADES PROFESIONALES", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(500),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CALIFICADO POR EL INSTITUTO DE SEGURIDAD SOCIAL'))),
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FECHA'))),
                      
                           
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              2,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          E_AntecedentesFamiliares(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }





   void E_AntecedentesFamiliares(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "E. ANTECEDENTES FAMILIARES",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(150),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('1. ENFERMEDADES CARDIOVASCULARES'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('2. ENFERMEDAD METABÓLICA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('3. ENFERMEDAD DEUROLÓGICA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('4. ENFERMEDAD ONCOLÓGICA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('5. ENFERMEDAD INFECCIOSA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('6. ENFERMEDAD HEREDITARIA/CONGENITA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('7. DISCAPACIDADES'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('8. OTROS'))),
        ],
      ),
   
    ],
  ),
),

                    const SizedBox(height: 24),
                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(900),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('OBSERVACIONES'))),
                                              
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              1,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

             ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          F_FactoresoresDeRiesgoPuestoTrabajoActual(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }



   void F_FactoresoresDeRiesgoPuestoTrabajoActual(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "F. FACTORES DE RIESGO DEL PUESTO DE TRABAJO ACTUAL",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(250),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PUESTO DE TRABAJO/AREA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('ACTIVIDADES'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FISICO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('MECANICO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('QUIMICO'))),
        ],
      ),
      TableRow(
        children: [
          // PUESTO DE TRABAJO / AREA
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // ACTIVIDADES
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // FISICO
            Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Temperaturas altas', child: Text('Temperaturas altas')),
                DropdownMenuItem(value: 'Temperaturas bajas', child: Text('Temperaturas bajas')),
                DropdownMenuItem(value: 'Radiacion', child: Text('Radiacion')),
                DropdownMenuItem(value: 'Radiacion No', child: Text('Radiacion No')),
                DropdownMenuItem(value: 'Ruido', child: Text('Ruido')),
                DropdownMenuItem(value: 'Vibracion', child: Text('Vibracion')),
                DropdownMenuItem(value: 'Fluido Electrico', child: Text('Fluido Electrico')),
                DropdownMenuItem(value: 'Otros', child: Text('Otros')),
                
                
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),

          // MECANICO
          Padding(
            padding: const EdgeInsets.all(8),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Atrapamiento entre maquinas', child: Text('Atrapamiento entre maquinas')),
                DropdownMenuItem(value: 'Atrapamiento entre superficies', child: Text('Atrapamiento entre superficies')),
                DropdownMenuItem(value: 'Atrapamiento entre objetos', child: Text('Atrapamiento entre objetos')),
                DropdownMenuItem(value: 'Caida de objetos', child: Text('Caida de objetos')),
                DropdownMenuItem(value: 'Caidas al mismo nivel', child: Text('Caidas al mismo nivel')),
                DropdownMenuItem(value: 'Caida a diferente nivel', child: Text('Caida a diferente nivel')),
                DropdownMenuItem(value: 'Contacto a superficies de trabajo', child: Text('Contacto a superficies de trabajo')),
                DropdownMenuItem(value: 'Proyeccion de particulas - fragmentos', child: Text('Proyeccion de particulas - fragmentos')),
                DropdownMenuItem(value: 'Proyeccion de fluidos', child: Text('Proyeccion de fluidos')),
                DropdownMenuItem(value: 'Pinchazos', child: Text('Pinchazos')),
                DropdownMenuItem(value: 'Cortes', child: Text('Cortes')),
                DropdownMenuItem(value: 'Atropellamiento por vehículo', child: Text('Atropellamiento por vehículo')),
                DropdownMenuItem(value: 'Choques - colisión vehicular', child: Text('Choques - colisión vehicular')),
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),
          // QUIMICO
          Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Sonidos', child: Text('Sonidos')),
                DropdownMenuItem(value: 'Polvos', child: Text('Polvos')),
                DropdownMenuItem(value: 'Humos', child: Text('Humos')),
                DropdownMenuItem(value: 'Liquidos', child: Text('Liquidos')),
                DropdownMenuItem(value: 'Vapores', child: Text('Vapores')),
                DropdownMenuItem(value: 'Aerosoles', child: Text('Aerosoles')),
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),

        ],
      ),
    ],
  ),
),

                  
                  
                  
                  
                    const SizedBox(height: 24),
                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal

SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: IntrinsicWidth(
    child: Table(
      border: TableBorder.all(),
      defaultColumnWidth: const FixedColumnWidth(260),
      children: [
        TableRow(
          decoration: BoxDecoration(color: Colors.grey[300]),
          children: const [
            TableCell(
              child: Padding(
                padding: EdgeInsets.all(8),
                child: Text('PUESTO DE TRABAJO / AREA'),
              ),
            ),
            TableCell(
              child: Padding(
                padding: EdgeInsets.all(8),
                child: Text('BIOLÓGICO'),
              ),
            ),
            TableCell(
              child: Padding(
                padding: EdgeInsets.all(8),
                child: Text('ERGONÓMICO'),
              ),
            ),
            TableCell(
              child: Padding(
                padding: EdgeInsets.all(8),
                child: Text('PSICOSOCIAL'),
              ),
            ),
            TableCell(
              child: Padding(
                padding: EdgeInsets.all(8),
                child: Text('MEDIDAS PREVENTIVAS'),
              ),
            ),
          ],
        ),
        TableRow(
          children: [
            // Campo: PUESTO DE TRABAJO / AREA
            const Padding(
              padding: EdgeInsets.all(4),
              child: TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  isDense: true,
                ),
              ),
            ),

            // Dropdown: BIOLÓGICO
            Padding(
              padding: const EdgeInsets.all(4),
              child: DropdownButtonFormField<String>(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  isDense: true,
                ),
                items: const [
                  DropdownMenuItem(value: 'Virus', child: Text('Virus')),
                  DropdownMenuItem(value: 'Hongos', child: Text('Hongos')),
                  DropdownMenuItem(value: 'Bacterias', child: Text('Bacterias')),
                  DropdownMenuItem(value: 'Parasitos', child: Text('Parasitos')),
                  DropdownMenuItem(value: 'Roedores', child: Text('Exposición a Roedores')),
                  DropdownMenuItem(value: 'Animales', child: Text('Exposición a animales selváticos')),
                ],
                onChanged: (value) {},
                hint: const Text("Seleccione"),
              ),
            ),

            // Dropdown: ERGONÓMICO
            Padding(
              padding: const EdgeInsets.all(4),
              child: DropdownButtonFormField<String>(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  isDense: true,
                ),
                items: const [
                  DropdownMenuItem(value: 'Cargas', child: Text('Manejo manual de cargas')),
                  DropdownMenuItem(value: 'Repetitivos', child: Text('Movimientos repetitivos')),
                  DropdownMenuItem(value: 'Posturas', child: Text('Posturas forzadas')),
                  DropdownMenuItem(value: 'PVD', child: Text('Trabajos con PVD')),
                ],
                onChanged: (value) {},
                hint: const Text("Seleccione"),
              ),
            ),

            // Dropdown: PSICOSOCIAL
            Padding(
              padding: const EdgeInsets.all(4),
              child: DropdownButtonFormField<String>(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  isDense: true,
                ),
                items: const [
                  DropdownMenuItem(value: 'Monotonia', child: Text('Monotonía en el trabajo')),
                  DropdownMenuItem(value: 'Sobrecarga', child: Text('Sobrecarga laboral')),
                  DropdownMenuItem(value: 'Responsabilidad', child: Text('Alta responsabilidad')),
                  DropdownMenuItem(value: 'Autonomia', child: Text('Autonomía en la toma de decisiones')),
                  DropdownMenuItem(value: 'Rol', child: Text('Conflicto de rol')),
                  DropdownMenuItem(value: 'Distribución', child: Text('Distribución inadecuada de trabajo')),
                  DropdownMenuItem(value: 'Turnos', child: Text('Turnos rotativos')),
                  DropdownMenuItem(value: 'Relaciones', child: Text('Relaciones interpersonales')),
                  DropdownMenuItem(value: 'Inestabilidad', child: Text('Inestabilidad laboral')),
                ],
                onChanged: (value) {},
                hint: const Text("Seleccione"),
              ),
            ),

            // Campo: MEDIDAS PREVENTIVAS
            const Padding(
              padding: EdgeInsets.all(4),
              child: TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  isDense: true,
                ),
              ),
            ),
          ],
        ),
      ],
    ),
  ),
)
         
                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),
 ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          G_ActividadesExtraLaborales(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
            
          ],
        ),
      ),
    );
  },
);

  }



   void G_ActividadesExtraLaborales (BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "G. ACTIVIDADES EXTRA LABORALES",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(600),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('DESCRIPCION'))),
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          H_HerramientaActual(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }


   void H_HerramientaActual(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "H. HERRAMIENTA ACTUAL",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(600),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('DESCRIPCION'))),
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          J_ConstantesVitalesAntropometria(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }

void J_ConstantesVitalesAntropometria(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "J. CONSTANTES VITALES Y ANTROPOMETRIA",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(150),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PRESION ARTERIAL'))),
           TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TEMPERATURA (°C)'))),
            TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FRECUENCIA CARDIACA'))),
             TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('SATURACION DE OXIGENO'))),
              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FRECUENCIA RESPIRATORIA'))),
               TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PESO'))),
                TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TALLA'))),
                 TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('INDICE DE MASA CORPORAL'))),
                  TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PERIMETRO ABDOMINAL'))),
                 
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),


          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          K_ExamenFisicoRegional(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }




   void K_ExamenFisicoRegional(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "K. EXAMEN FISICO REGIONAL",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("REGIONES", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(200),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PIEL'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('OJOS'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('OIDO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('ORO FARINGE'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('NARIZ'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CUELLO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('TORAX'))),
        ],
      ),
      TableRow(
        children: [
          // PIEL
                 Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Cicatrices', child: Text('a. Cicatrices')),
                DropdownMenuItem(value: 'Tatuajes', child: Text('b. Tatuajes')),
                DropdownMenuItem(value: 'Piel', child: Text('c. Piel')),
       
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),

          // OJOS
           Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Parpados', child: Text('a. Parpados')),
                DropdownMenuItem(value: 'Conjuntivas', child: Text('b. Conjuntivas')),
                DropdownMenuItem(value: 'Pupilas', child: Text('c. Pupilas')),
                DropdownMenuItem(value: 'Cornea', child: Text('c. Cornea')),
                       DropdownMenuItem(value: 'Motilidad', child: Text('d. Motilidad')),
       
       
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),
        
        
          // OIDO
          Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Auditivo Externo', child: Text('a. Auditivo Externo')),
                DropdownMenuItem(value: 'Pabellon', child: Text('b. Pabellon')),
                DropdownMenuItem(value: 'Timpanos', child: Text('c. Timpanos')),
       
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),


          // ORO FARINGE
         Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Labios', child: Text('a. Labios')),
                DropdownMenuItem(value: 'Lengua', child: Text('b. Lengua')),
                DropdownMenuItem(value: 'Faringe', child: Text('c. Faringe')),
                DropdownMenuItem(value: 'Amigdalas', child: Text('c. Amigdalas')),
                       DropdownMenuItem(value: 'Dentadura', child: Text('d. Dentadura')),
       
       
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),



          // NARIZ
           Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Tabique', child: Text('a. Tabique')),
                DropdownMenuItem(value: 'Cometes', child: Text('b. Cometes')),
                DropdownMenuItem(value: 'Mucosa', child: Text('c. Mucosa')),
                DropdownMenuItem(value: 'Senos Paranasales', child: Text('d. Senos Paranasales')),
                      
       
       
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),


          // TORAX
          Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Mamas', child: Text('a. Mamas')),
                DropdownMenuItem(value: 'Corazon', child: Text('b. Corazon')),
                    DropdownMenuItem(value: 'Pulmones', child: Text('b. Pulmones')),
                        DropdownMenuItem(value: 'Parrilla Costal', child: Text('b. Parrilla Costal')),
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),




      // CUELLO
          Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Tiroides / Masas', child: Text('a. Tiroides / Masas')),
                DropdownMenuItem(value: 'Movilidad', child: Text('b. Movilidad')),
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),





        ],
      ),
    ],
  ),
),

                    const SizedBox(height: 24),
                    const Text("REGIONES", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(190),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                             TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('ABDOMEN'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('COLUMNA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('PELVIS'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('EXTREMIDADES'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('NEUROLOGICO'))),
                           
                            ],
                          ),
                          TableRow(
                            children:  [
                         
                          //    ABDOMEN
                              Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Visceras', child: Text('a. Visceras')),
                DropdownMenuItem(value: 'Pared Abdominal', child: Text('b. Pared Abdominal')),
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),


//    COLUMNA
                              Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Flexibilidad', child: Text('a. Flexibilidad')),
                DropdownMenuItem(value: 'Desviacion', child: Text('b. Desviacion')),
                  DropdownMenuItem(value: 'Dolor', child: Text('c.Dolor')),
                  
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),



//    PELVIS
                              Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Pelvis', child: Text('a. Pelvis')),
                DropdownMenuItem(value: 'Genitales', child: Text('b. Genitales')),
         
                  
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),


          
//    EXTREMIDADES
                              Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Vascular', child: Text('a. Vascular')),
                DropdownMenuItem(value: 'Miembros Superiores', child: Text('b. Miembros Superiores')),
                DropdownMenuItem(value: 'Miembros Inferiores', child: Text('c. Miembros Inferiores')),
           
         
                  
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),



//    NEUROLOGICO
                              Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Fuerza', child: Text('a. Fuerza')),
                DropdownMenuItem(value: 'Sensibilidad', child: Text('b. Sensibilidad')),
                DropdownMenuItem(value: 'Marcha', child: Text('c. Marcha')),
                   DropdownMenuItem(value: 'Reflejos', child: Text('c. Reflejos')),
           
         
                  
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),
                           
 ],
                          ),
                        ],
                      ),
                    ),

          


                          
            
                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          L_ResultadosExamenesGenerales(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }

     void L_ResultadosExamenesGenerales(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "L. RESULTADOS DE EXAMENES GENERALES",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(400),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('EXAMEN'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FECHA'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('RESULTADOS'))),
        
        ],
      ),
      TableRow(
        children: [
          // EXAMEN
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // FECHA
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          // RESULTADOS
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

         

          

  
        ],
      ),
    ],
  ),
),

                   

                    // Tabla 2 con scroll horizontal
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Table(
                        border: TableBorder.all(),
                        defaultColumnWidth: const FixedColumnWidth(550),
                        children: [
                          TableRow(
                            decoration: BoxDecoration(color: Colors.grey[300]),
                            children: const [
                              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('OBSERVACIONES'))),
                              
                    
                           
                            ],
                          ),
                          TableRow(
                            children: List.generate(
                              1,
                              (_) => const Padding(
                                padding: EdgeInsets.all(4),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    isDense: true,
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),

                    // TABLA 3


                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          M_Diagnostico(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }

  void M_Diagnostico (BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "M. DIAGNOSTICO",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(600),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('DESCRIPCION'))),
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          N_AptitudMedicaTrabajo(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }




void N_AptitudMedicaTrabajo(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "N. APTITUD MEDICA EN EL TRABAJO",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(250),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('APTO'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('APTO EN OBSERVACION'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('APTO CON LIMITACIONES'))),
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('NO APTO'))),

        ],
        
      ),
        TableRow(
        children: [
          
          // APTO
          Padding(
            padding: const EdgeInsets.all(4),
            child: DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
              items: const [
                DropdownMenuItem(value: 'Observación', child: Text('Observación')),
                DropdownMenuItem(value: 'Limitación', child: Text('Limitación')),
                
              ],
              onChanged: (value) {},
              hint: const Text("Seleccione"),
            ),
          ),

          // APTO EN OBSERVACION
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),


          // APTO CON LIMITACION
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),


          // NO APTO 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),
        ],
      ),
   
    ],
  ),
),


                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

             ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                           O_RecomendacionesY_OTratamiento(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }

   void O_RecomendacionesY_OTratamiento(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "O. RECOMENDACIONES Y/O TRATAMIENTO",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 8),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(600),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('DESCRIPCION'))),
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          P_DatosDelProfesional(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }

  void P_DatosDelProfesional(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "P. DATOS DEL PROFESIONAL",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 5),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(150),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FECHA (aaaa/mm/dd)'))),
           TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('HORA'))),
            TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('NOMBRES Y APELLIDOS'))),
             TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('CÓDIGO'))),
              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FIRMA Y SELLO'))),
               
                 
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

           const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

        



          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),


             ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                     Firma(context);                     
                      },
                      child: Text("Firmar"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),

            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          Q_RectasEnviadas(context);                    
                      },
                      child: Text("Siguiente Registro"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }

void Firma(BuildContext context) {
  final TextEditingController _claveController = TextEditingController();

  showDialog(
    context: context,
    barrierDismissible: false, // evita cerrar tocando fuera del diálogo
    builder: (BuildContext dialogContext) {
      return Dialog(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(15),
        ),
        elevation: 8,
        child: Container(
          padding: const EdgeInsets.all(20),
          constraints: const BoxConstraints(maxWidth: 400),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "Ingrese su clave",
                style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                  color: Colors.blue[800],
                ),
              ),
              const SizedBox(height: 15),
              TextField(
                controller: _claveController,
                obscureText: true,
                decoration: const InputDecoration(
                  labelText: "Clave",
                  prefixIcon: Icon(Icons.lock_outline),
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 25),
              Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                   ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                          P_DatosDelProfesional(context);                    
                      },
                      child: Text("Cancelar"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
                  const SizedBox(width: 10),
                  ElevatedButton(
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.blue[800],
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(8),
                      ),
                    ),
                    onPressed: () {
                      String clave = _claveController.text.trim();
                      if (clave.isEmpty) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(
                            content: Text("Por favor, ingrese su clave."),
                          ),
                        );
                        return;
                      }
                      Navigator.of(dialogContext).pop();

                      // Acción cuando la clave es ingresada
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text("Clave ingresada: $clave"),
                        ),
                      );
                    }, 
                    child: const Text("Aceptar"),
                  ),


                 
                ],
              ),
            ],
          ),
        ),
      );
 },
);
}








  


 void Q_RectasEnviadas(BuildContext context) {

showDialog(
  context: context,
  builder: (context) {
    return Dialog(
      child: Container(
        width: MediaQuery.of(context).size.width * 0.95,
        height: MediaQuery.of(context).size.height * 0.85,
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text(
              "Q. RECTAS ENVIADAS",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            // CONTENIDO SCROLLEABLE
            Expanded(
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [

                    const Text("", style: TextStyle(fontWeight: FontWeight.bold)),
                    const SizedBox(height: 5),

                    // Tabla 1 con scroll horizontal
                  SingleChildScrollView(
  scrollDirection: Axis.horizontal,
  child: Table(
    border: TableBorder.all(),
    defaultColumnWidth: const FixedColumnWidth(150),
    children: [
      TableRow(
        decoration: BoxDecoration(color: Colors.grey[300]),
        children: const [
          TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('NUMERO DE RECETA'))),
           TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('DOCTOR/A'))),
            TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('DIAGNOSTICO'))),
             TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('RECETA'))),
              TableCell(child: Padding(padding: EdgeInsets.all(8), child: Text('FECHA'))),
               
                 
          
        ],
      ),
      TableRow(
        children: [
          // 
          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

          const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

           const Padding(
            padding: EdgeInsets.all(4),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                isDense: true,
              ),
            ),
          ),

        



          
        ],
      ),
    ],
  ),
),

  

                    
                  ],
                ),
              ),
            ),

            const SizedBox(height: 20),
            Align(
              alignment: Alignment.centerRight,
              child: ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: const Text("Guardar"),
              ),
            ),


            ElevatedButton(
                      onPressed: () {    
                          Navigator.of(context).pop();
                         // Paso a imprimir en formualario                    
                      },
                      child: Text("IMPRIMIR"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromARGB(255, 0, 119, 255),
                        foregroundColor: Colors.white,
                      ),
                    ),
          ],
        ),
      ),
    );
  },
);

  }


  




  











  Widget buildInputField(String label) {
    return SizedBox(
      width: 250,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(label, style: TextStyle(fontWeight: FontWeight.bold)),
          SizedBox(height: 5),
          TextField(
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              isDense: true,
            ),
          ),
        ],
      ),
    );
  }

  Widget buildDropdownField(String label, List<String> options, {bool fullWidth = false}) {
    return SizedBox(
      width: fullWidth ? 520 : 250,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(label, style: TextStyle(fontWeight: FontWeight.bold)),
          SizedBox(height: 5),
          DropdownButtonFormField<String>(
            items: options.map((opt) => DropdownMenuItem(value: opt, child: Text(opt))).toList(),
            onChanged: (value) {},
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              isDense: true,
            ),
          ),
        ],
      ),
    );
  }
}