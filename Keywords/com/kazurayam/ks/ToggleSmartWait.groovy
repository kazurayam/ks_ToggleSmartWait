package com.kazurayam.ks

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain

public class ToggleSmartWait {

	public static void toggleON() throws StepFailedException {
		WebUIKeywordMain.runKeyword({
			RunConfiguration.getExecutionProperties().put(RunConfiguration.GLOBAL_SMART_WAIT_MODE, true)
			RunConfiguration.getExecutionProperties().put(RunConfiguration.LOCAL_SMART_WAIT_MODE, true)
		}, FailureHandling.CONTINUE_ON_FAILURE, true, "Unable to enable smart wait !")
	}

	public static void toggleOFF() throws StepFailedException {
		WebUIKeywordMain.runKeyword({
			RunConfiguration.getExecutionProperties().put(RunConfiguration.LOCAL_SMART_WAIT_MODE, false);
		}, FailureHandling.CONTINUE_ON_FAILURE, true, "Unable to disable smart wait !");
	}
}
