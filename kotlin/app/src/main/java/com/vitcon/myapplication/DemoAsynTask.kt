package com.vitcon.myapplication

import android.os.AsyncTask

class DemoAsynTask : AsyncTask<Void, Int, String> {
    private var handle: handleAsyntask? = null

    companion object {
        var demoAsynTask: DemoAsynTask? = null
        fun newInstance(handleAsyntask: handleAsyntask): DemoAsynTask {
            if (demoAsynTask == null){
                demoAsynTask = DemoAsynTask(handleAsyntask)
            }
            return demoAsynTask as DemoAsynTask
        }
    }

    constructor(handleAsyntask: handleAsyntask) {
        this.handle = handleAsyntask
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): String {
        var i: Int = 0
        while (i < 100) {
            i = i + 10
            Thread.sleep(1000)
            publishProgress(i)
        }
        return "Complete Task"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        handle?.updateDataProgress(values[0]!!)

    }

    override fun onPostExecute(result: String?) {
        handle?.updateDataSuccess(result!!)
        super.onPostExecute(result)
    }
}