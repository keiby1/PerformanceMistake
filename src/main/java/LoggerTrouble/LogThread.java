package LoggerTrouble;

import org.apache.log4j.Logger;

public class LogThread extends Thread {
    static final Logger logger = Logger.getLogger(LogThread.class);

    @Override
    public void run() {
        while (true) {

            if (logger.isTraceEnabled()) { //позволяет ускорить обработку в случае если уровень логирования ниже, и замедляет на незначительное значение (1% от стоимости вычисления самого лога)
                logger.trace(
                        "sd;fgnn".concat("gfdgdfgh").substring(3, 6).concat("sadfsdgdsfagfdsg")
                                .concat("safddsafsgfsdgafdg43qt24t43q")
                                .concat(Integer.toString(23432 * 25443543 / 324234543 * 56456 * 435345 * 54354351 / 435435354))
                                .concat("dsfdsfdsgdsgsdg")
                                .replace("h", "f")
                                .replace("f", "s")
                                .replace("h", "f")
                                .concat("gfdsgsfdgfdsgsfdgsfdg").toString()
                                .concat(Double.toString(Math.abs(1243) + Math.cos(432423423) * 4324324 + Math.sin(12342) / 14324324 + Math.cos(432423423) * 4324324 + Math.sin(12342) / 14324324 + Math.cos(432423423) * 4324324 + Math.sin(12342) / 14324324 + Math.cos(432423423) * 4324324 + Math.sin(12342) / 14324324))
                );
            }
            logger.debug("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
            logger.info("INFO logggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
            logger.error("Some error");
        }
    }
}
