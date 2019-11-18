import groovyx.javafx.beans.FXBindable
import org.apache.commons.lang3.RandomStringUtils

class PassGenerator {
    Integer minAllowedPassLength = 8
    Integer maxAllowedPassLength = 32
    @FXBindable String pwd

    List getAllowedLength(){
        List list = []
        (this.minAllowedPassLength..this.maxAllowedPassLength).each {
            list.add(it)
        }
        return list
    }

    String genPass(Integer passLength) {
        if (passLength == null) {
            passLength = minAllowedPassLength
        }
        String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9') + '!@#$%^&*').join()
        String randomString = RandomStringUtils.random(passLength, charset.toCharArray())
        this.pwd = randomString
    }
}
