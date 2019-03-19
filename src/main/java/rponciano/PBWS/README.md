# Progress Bar With Service
Class created for progress bar creation when using methods that may take time to load/terminate.

This code<br>
![LWC-code](https://user-images.githubusercontent.com/6250218/54213594-6bd5dc80-44c3-11e9-8c12-3b34d71da862.png)

Generate this result<br>
![result](https://user-images.githubusercontent.com/6250218/54117772-4b792580-43d0-11e9-9729-b9ab2b542155.png)

<b>When instantiating an object of this class, you must override two methods:</b>

- public R methodToBeLoad() throws Exception<br>
This method must contain the calls and executions that are responsible for the delay and the need to use this class.
<br><br>
- public void actionAfterSuccess(R result)<br>
This method must contain calls and executions that will process / use / execute the result of the methodToBeLoad () method. That is, the processes that must be executed after the expected completion of the task. 