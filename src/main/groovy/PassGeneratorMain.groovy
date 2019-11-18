import javafx.scene.image.Image

import static groovyx.javafx.GroovyFX.start

class PassGeneratorMain {

    public static void main(String[] args) {
        Integer maxPassLength
        PassGenerator PS = new PassGenerator()

        start { //start GroovyFX
            stage(title: "Password Generator", width: 350, height: 200, visible: true, icons: new Image(PassGeneratorMain.class.getResourceAsStream('myApp_125x125.png'))) {
                scene(fill: GROOVYBLUE) {
                    vbox(spacing: 10,padding: 10) {
                        hbox(){
                            text("Pswd Length: ")
                            choiceBox(items: PS.getAllowedLength()) {
                                onSelect { control, item ->
                                    //println "Got selection for $control, item is $item"
                                    maxPassLength = item
                                    println "Pass Length: " + maxPassLength
                                }
                            }
                        }
                        hbox(){
                            button(text: "Gen", onAction: {
                                println('Generating....')
                                PS.genPass(maxPassLength)
                            })
                        }
                        hbox(){
                            textField(text: bind(PS.pwdProperty()), prefColumnCount: 23)
                        }

                    }
                } //end scene
            } //end stage
        } //end start
    }
}
